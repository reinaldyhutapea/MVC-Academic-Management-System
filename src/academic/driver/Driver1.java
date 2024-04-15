package academic.driver;
import academic.model.*;
import java.util.Scanner;
/**
 * @author 12S22010 - REINALDY HUTAPEA
 */
public class Driver1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Executor model = new Executor(); 
        Controller controller = new Controller(model);

        while (input.hasNextLine()) {
            String masukan = input.nextLine();
            String[] data = masukan.split("#");
            String command = data[0];

            if (command.equals("---")) {
                break;
            } else {
                controller.processCommand(command, data);
            }
        }

        input.close();
        model.printAll();
    }
}