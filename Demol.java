import java.io.*;
public class Demol {
class MyClass implements Serializable {
    private int id;
    private String name;

    public MyClass(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
    public static void main(String[] args) {
        String filePath = "/your/serialized/file/path.ser"; // 请替换为实际存档文件路径
        // 存档（序列化）
        MyClass myObject = new MyClass(1, "示例对象");
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(myObject);
            System.out.println("对象已成功序列化并保存");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 读档（反序列化）
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            MyClass deserializedObject = (MyClass) ois.readObject();
            System.out.println("反序列化对象 - id: " + deserializedObject.getId() + ", name: " + deserializedObject.getName());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
    


   
