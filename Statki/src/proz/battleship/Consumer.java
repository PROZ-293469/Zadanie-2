package proz.battleship;
import javax.jms.ConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.JMSConsumer;
import javax.jms.Queue;
import javax.jms.TextMessage;

public class Consumer {

	private JMSContext jmsContext;
	private JMSConsumer jmsConsumer;
	private Queue queue;
	
	Consumer(String url, String queueName) throws JMSException {
		ConnectionFactory connectionFactory = new com.sun.messaging.ConnectionFactory();
		//[hostName][:portNumber][/serviceName]
		//7676 numer portu, na ktorym JMS Service nasluchuje polaczen
		//"localhost:7676/jms"
		jmsContext = connectionFactory.createContext();
		((com.sun.messaging.ConnectionFactory)connectionFactory).setProperty(com.sun.messaging.ConnectionConfiguration.imqAddressList,url);
		queue = new com.sun.messaging.Queue(queueName);
		jmsConsumer = jmsContext.createConsumer(queue);
	}
	
	public String receiveQueueMessage() throws JMSException {
		Message msg = jmsConsumer.receive(10);
		if (msg instanceof TextMessage) return ((TextMessage) msg).getText();
		return null;
	}
	
	public void finalize() {
		if (jmsConsumer!=null)
			jmsConsumer.close();
		if (jmsContext!=null)
			jmsContext.close();
	}
}
