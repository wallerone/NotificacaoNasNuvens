package br.com.hachitecnologia.gcm.util;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import br.com.hachitecnologia.gcm.R;
import br.com.hachitecnologia.gcm.activity.MostraMensagemActivity;

/**
 * Classe utilitária para mostrar notificações.
 * 
 * @author lucasfreitas
 *
 */
public class Notificacao {
	 
    /**
     * M�todo respons�vel por disparar uma notifica��o na barra de status.
     * 
     * @param titulo
     * @param mensagem
     * @param context
     */
    public static void mostraNotificacao(String titulo, String mensagem,
            Context context) {
 
        // Tempo em que a Notifica��o ser� disparada
        long tempoDefinido = System.currentTimeMillis();
 
        // Objeto Notification
        Notification notification = new Notification(R.drawable.ic_launcher,
                titulo, tempoDefinido);
 
        // Intent que ser� disparada quando o usu�rio clicar sobre a Notifica��o
        Intent intent = new Intent(context, MostraMensagemActivity.class);
        intent.putExtra("mensagem_recebida", mensagem);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0,
                intent, PendingIntent.FLAG_UPDATE_CURRENT);
 
        // Configurando os dados da Notifica��o
        notification.setLatestEventInfo(context, titulo, mensagem,
                pendingIntent);
 
        // Oculta a notifica��o ap�s o usu�rio clicar sobre ela
        notification.flags |= Notification.FLAG_AUTO_CANCEL;
         
        // Define alertas de acordo com o padr�o definido no dispositivo
        notification.defaults = Notification.DEFAULT_ALL;
 
        // Agenda a Notifica��o
        NotificationManager notificationManager = (NotificationManager) context
                .getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0, notification);
    }
}
