import java.util.Properties;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class SyncProducer {
	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println("Please pass topic name.");
			return;
		}

		String topic = args[0].toString();

		Properties props = new Properties();
		props.put("bootstrap.servers", "localhost:9092");
		props.put("key.serializer",
			"org.apache.kafka.common.serialization.StringSerializer");
		props.put("value.serializer",
			"org.apache.kafka.common.serialization.StringSerializer");

		Producer<String, String> producer = new KafkaProducer<String, String>(props);

		ProducerRecord<String, String> record = new ProducerRecord<>(
				topic, "Precision Product", "France");

		try {
			// producer.send() returns Future, wait for it to complete.
			producer.send(record).get();
		}  catch (Exception e) {
			e.printStackTrace();
		}
	}
};