//public class RocketTest {
//
//
//
//
//    public void testConsumer(){
//        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("MQ_ORC_SPLIT_RESULT_TO_OFA_DEV");
//        consumer.setNamesrvAddr("10.88.26.79:9876");
//
//        try {
//            // 订阅PushTopic下的Tag未push的消息
//            consumer.subscribe("MQ_ORC_SPLIT_RESULT_TO_OFA_DEV", "*");
//            // 程序第一次启动从消息队列头取数据
//            consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
//            consumer.registerMessageListener(new MessageListenerConcurrently() {
//                @Override
//                public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
//                    Message message = msgs.get(0);
//                    System.err.println(message.toString());
//                    return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
//                }
//            });
//            consumer.start();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//    public void testProducer(){
//        DefaultMQProducer producer = new DefaultMQProducer("Producer");
//        producer.setNamesrvAddr("127.0.0.1:9876");
//
//        try {
//
//            producer.start();
//
//            Message message = new Message("PushTopic", "push", "1", "Just fot test.".getBytes());
//            SendResult result = producer.send(message);
//            System.out.println("id:" + result.getMsgId() + " result:" + result.getSendStatus());
//
//            message = new Message("PushTopic", "push", "3", "Just fot test.".getBytes());
//
//            result = producer.send(message);
//            System.out.println("id:" + result.getMsgId() + " result:" + result.getSendStatus());
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            producer.shutdown();
//        }
//    }
//}
