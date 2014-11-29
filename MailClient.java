
/**
 * Write a description of class MailClient here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MailClient
{
    private MailServer server;
    private String user;
    private MailItem savedEmail;
    
    public MailClient(MailServer server, String user){
        this.server = server;
        this.user = user;
        //Actualizamos por si hubiese algun mensaje en el servidor pendiente y
        //de paso inicializamos la variable savedEmail
        actualice();
    }
    /**
     * Metodo que obtiene el ultimo mensaje que halla para el usuario del cliente y
     * lo retorna.
     * El email se borra del servidor y el método no lo guarda
     */
    public MailItem getNextMailItem(){
        actualice();
        return savedEmail;
    }
    /**
     * Imprime el último mensaje del servidor mediante el metodo local 
     * getNextMailItem y lo imprime por pantalla mediante el metodo de MailItem
     * print.
     * Si no hay mensajes en el servidor, avisa de ello.
     */
    public void printNextMailItem(){
        actualice();
        print();
    }
    /**
     * Envia un email a otro usuario
     */
    public void sendMailItem(String to, String subject, String message){
        MailItem email = new MailItem(user, to, subject, message);
        server.post(email);
    }
    /**
     * método que responderá automaticamente los mensajes contestando que estamos
     * de vacaciones
     */
    public void getNextMailItemAndAutorespond(){
        //actualiza la memoria
        actualice();
        //Comprobamos que hubiese algún email y en caso afirmativo lo procesamos
        if(savedEmail != null){
            //Para ello nos creamos dos variables locales donde poder guardar
            //La información y cambiarla
            String subject = "RE: " + savedEmail.getSubject();
            String message = "Estoy de vacaciones \n" + savedEmail.getMessage();
            
            //Enviamos el email al que nos lo envio
            sendMailItem(savedEmail.getFrom(), subject, message);
        }
    }
    /**
     * Muestra por pantalla cuantos emails pendientes tiene el cliente
     */
    public void howManyEmails(){
        System.out.println("Hay " + server.howManyMailItems(user) + " Mensajes nuevos.");
    }
    /**
     * Método que muestra por pantalla el último email recibido
     */
    public void printLastMailItem(){
        print();
    }
    /**
     * PRIVADO:
     * Imprime por pantalla el email guardad en memoria
     */
    private void print(){
        if(savedEmail != null){
            savedEmail.print();
        }
        else{
            System.out.println("No hay mensajes pendientes");
        }
    }
    /**
     * PRIVADO:
     * Metodo que descarga el último mensaje en servidor y lo guarda en memoria
     */
    private void actualice(){
        savedEmail = server.getNextMailItem(user);
    }
}
