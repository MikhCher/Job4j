package ru.job4j.tracker;

public class FindByNameAction extends BaseAction {
    private boolean call = false;

    public FindByNameAction(int key) {
        super(key, "Find items by name");
    }
    @Override
    public boolean execute(Input input, Tracker tracker) {
        call = true;
        if (tracker.findAll().length == 0) {
            System.out.println("There are no any items. You should create at least one item.");
            return true;
        }
        Item[] array = tracker.findByName(input.askStr("Enter name: "));
        if (array.length != 0) {
            for (int i = 0; i < array.length; i++) {
                System.out.println("#" + array[i].getId() + ", " + array[i].getName());
            }
        } else {
            System.out.println("There is no items with this name");
        }
        return true;
    }
    public boolean isCall() {
        return call;
    }
}
