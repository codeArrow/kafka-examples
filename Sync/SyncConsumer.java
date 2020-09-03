import java.util.Properties;
import java.util.Arrays;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import java.time.Duration;

public class SyncConsumer {
	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println("Enter the topic name.");
			return;
		}

		String topic = args[0].toString();

		Properties props = new Properties();
		props.put("bootstrap.servers", "localhost:9092");
		props.put("key.deserializer",
			"org.apache.kafka.common.serialization.StringDeserializer");
		props.put("value.deserializer",
			"org.apache.kafka.common.serialization.StringDeserializer");
		props.put("group.id", "test");

		KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
		consumer.subscribe(Arrays.asList(topic));

		while (true) {
			ConsumerRecords<String, String> records =
				consumer.poll(Duration.ofSeconds(1));
			for (ConsumerRecord<String, String> record : records) {
				System.out.printf("offset = %d, key = %s, value = %s\n",
					record.offset(), record.key(), record.value());
			}
		}
	}
};