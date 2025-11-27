package notificacao.factory;

import notificacao.Notificador;
import notificacao.NotificadorEmail;
import notificacao.NotificadorSMS;
import notificacao.NotificadorWhatsApp;

public class NotificadorFactory {

    public static Notificador criar(TipoNotificacao tipo) {
        return switch (tipo) {
            case EMAIL -> new NotificadorEmail();
            case SMS ->  new NotificadorSMS();
            case WHATSAPP -> new NotificadorWhatsApp();
        };
    }
}
