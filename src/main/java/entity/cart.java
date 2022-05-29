package entity;

public class cart {

   private Food food;
   private int count;

    public cart() {
    }

    public cart(Food food, int count) {
        this.food = food;
        this.count = count;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
