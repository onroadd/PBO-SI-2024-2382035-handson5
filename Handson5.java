import java.util.Scanner;

public class Main {
    public static String[] todos = new String[3];
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("BEFORE EDIT");
        addTodoList("Mewarnai");
        addTodoList("Membaca");
        addTodoList("Bersepeda");
        addTodoList("Berkhotbah"); // This will not be added due to array size
        showTodoList();
        editTodoList(3, "Bekerja"); // This will edit the third todo
        System.out.println("AFTER EDIT");
        showTodoList();
    }

    public static void showTodoList() {
        System.out.println("TODO LIST");
        for (int i = 0; i < todos.length; i++) {
            String todo = todos[i];
            if (todo != null) {
                System.out.println((i + 1) + ". " + todo);
            }
        }
    }

    public static void addTodoList(String todo) {
        resizeArrayIfFull();
        for (int i = 0; i < todos.length; i++) {
            if (todos[i] == null) {
                todos[i] = todo;
                break;
            }
        }
    }

    public static void resizeArrayIfFull() {
        if (isArrayFull()) {
            resizeArrayToTwoTimesBigger();
        }
    }

    public static boolean isArrayFull() {
        for (String todo : todos) {
            if (todo == null) {
                return false;
            }
        }
        return true;
    }

    public static void resizeArrayToTwoTimesBigger() {
        String[] temp = todos;
        todos = new String[todos.length * 2];
        System.arraycopy(temp, 0, todos, 0, temp.length);
    }

    public static boolean removeTodoList(int number) {
        if (isSelectedTodoNotValid(number)) {
            return false;
        }
        for (int i = number - 1; i < todos.length - 1; i++) {
            todos[i] = todos[i + 1];
        }
        todos[todos.length - 1] = null; // Clear last element
        return true;
    }

    public static boolean isSelectedTodoNotValid(int number) {
        if (number <= 0 || number > todos.length || todos[number - 1] == null) {
            return true;
        }
        return false;
    }

    public static boolean editTodoList(int number, String newTodo) {
        if (isSelectedTodoNotValid(number)) {
            return false;
        }
        todos[number - 1] = newTodo;
        return true;
    }
}
