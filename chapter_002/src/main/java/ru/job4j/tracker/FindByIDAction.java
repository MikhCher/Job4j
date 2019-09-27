package ru.job4j.tracker;

public class FindByIDAction implements UserActions {
    private boolean call = false;

    @Override
    public String name() {
        return "Find Item by ID";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        call = true;
        String id = input.askStr("Enter ID: ");
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println("#" + item.getId() + ", " + item.getName());
        } else {
            System.out.println("There is no item with this id");
        }
        return true;
    }
    public boolean isCall() {
        return call;
    }
}
