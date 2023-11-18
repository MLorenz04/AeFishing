
package aemmo.aefishing.Handlers;

import java.io.*;
import java.util.List;

import aemmo.aefishing.CommandExecutors.SingleFishForMenu;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;

public class SerializationHandler {

    public static List<SingleFishForMenu> deserializeFishes(String filePath) {
        try {
            /*  34 */       FileReader reader = new FileReader(filePath);
            /*  37 */       Yaml yaml = new Yaml();
            /*  40 */       List<SingleFishForMenu> cathegories = (List<SingleFishForMenu>)yaml.load(reader);

            /*  42 */       return cathegories;
            /*  43 */     } catch (IOException e) {
            /*  44 */       e.printStackTrace();

            /*  46 */       return null;
        }
    } public static void serializeFishes(List<SingleFishForMenu> cathegories, String filePath) {
        DumperOptions options = new DumperOptions();
        options.setIndent(2);
        options.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);

        Yaml yaml = new Yaml(options);
        String yamlData = yaml.dump(cathegories);

        try {
            FileWriter writer = new FileWriter(filePath);
            writer.write(yamlData);
            writer.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

}
