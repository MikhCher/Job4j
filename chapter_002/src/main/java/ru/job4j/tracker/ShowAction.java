package ru.job4j.tracker;

public class ShowAction extends BaseAction {
    private boolean call = false;

    public ShowAction(int key) {
        super(key, "Show all items");
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        call = true;
        Item[] array = tracker.findAll();
        if (array.length == 0) {
            System.out.println("There are no any items.");
        }
        for (int i = 0; i < array.length; i++) {
            System.out.println("#" + array[i].getId() + ", " + array[i].getName());
        }
        return true;
    }

    public boolean isCall() {
        return call;
    }
}
