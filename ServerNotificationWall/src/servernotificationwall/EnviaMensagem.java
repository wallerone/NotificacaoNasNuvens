/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servernotificationwall;

import javax.naming.spi.DirStateFactory.Result;

/**
 *
 * @author wallace
 */
public class EnviaMensagem {
     
    // Variável com o ID do dispositivo registrado no GCM
    private static final String ID_DISPOSITIVO_GCM = "AIzaSyAGGu9fJUd2qsS0EZ5rQ-558kw4cJ1Z930";
    // Variável com a chave obtida em API ACCESS no Google APIs
    private static final String API_KEY = "*";
     
    public static void main(String[] args) {
         
        /**
         * ID do Sender (Enviador)
         */
        Sender sender = new Sender(API_KEY);
         
        /**
         * Mensagem a ser enviada
         */
        Message message = new Message.Builder()
           .collapseKey("1")
           .timeToLive(3)
           .delayWhileIdle(true)
           .addData("mensagem", // identificador da mensagem
             "Olá! Este é um teste de envio de mensagem através do GCM!")
           .build();
         
        Result result = null;
         
        /**
         * Envia a mensagem para o dispositivo
         */
        try {
            result = sender.send(message,ID_DISPOSITIVO_GCM, 1);
        } catch (IOException e) {
            e.printStackTrace();
        }
         
        // Imprime o resultado do envio na saída padrão
        if (result != null)
            System.out.println(result.toString());
         
    }
 
}