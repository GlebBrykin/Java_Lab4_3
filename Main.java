import java.util.*;

public class Main
{
    public static void main(String[] args)
    {
        System.out.println("********************");
        System.out.println("Задача 1");
        System.out.println("********************");
        HashMap<Integer, String> students = new HashMap<Integer, String>();
        students.put(1234, "Ivan");
        students.put(5342, "Oleg");
        students.put(3153, "Olga");
        students.put(8532, "Anna");
        students.put(8394, "Vasiliy");
        for(HashMap.Entry<Integer, String> student : students.entrySet())
            System.out.printf("id: %d, name: %s\n", student.getKey(), student.getValue());
        System.out.print("Введите номер зачётки: ");
        Scanner scanner = new Scanner(System.in);
        Integer id = scanner.nextInt();
        if(students.containsKey(id))
            System.out.println("Студент найден: " + students.get(id));
        else
            System.out.println("Студент не найден!");

        System.out.println("********************");
        System.out.println("Задача 2");
        System.out.println("********************");
        System.out.println("Команды:");
        System.out.println("1 - Добавить заказ");
        System.out.println("2 - Вывести заказы для стола");
        System.out.println("3 - Вывести общее количество блюд");
        System.out.println("0 - Выход из программы");
        LinkedHashMap<Integer, LinkedList<String>> tables = new LinkedHashMap<Integer, LinkedList<String>>();
        while(true)
        {
            System.out.print(">>> ");
            switch(scanner.nextInt())
            {
                case 0:
                    return; // Сюда бы goto...
                case 1:
                    System.out.print("     Номер стола: ");
                    Integer table = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("     Блюдо: ");
                    String food = scanner.nextLine();
                    if(!tables.containsKey(table))
                        tables.put(table, new LinkedList<String>());
                    tables.get(table).add(food);
                    break;
                case 2:
                    System.out.print("     Номер стола: ");
                    table = scanner.nextInt();
                    if(!tables.containsKey(table))
                    {
                        System.out.println("     Стол с указанным номером не найден.");
                        break;
                    }
                    for(String food_ : tables.get(table))
                        System.out.println("     -> " + food_);
                    break;
                case 3:
                    LinkedHashSet<String> set = new LinkedHashSet<String>();
                    for(LinkedList<String> food_list : tables.values())
                        set.addAll(food_list);
                    System.out.println("Общее число уникальных блюд: " + set.size());
            }
        }
    }
}