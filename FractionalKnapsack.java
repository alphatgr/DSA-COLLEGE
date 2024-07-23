
class Item {
    int profit, weight;

    // Constructor
    public Item(int profit, int weight) {
        this.profit = profit;
        this.weight = weight;
    }
}

public class FractionalKnapsack {

    // Bubble Sort to sort items by profit-to-weight ratio
    private static void bubbleSort(Item[] items) {
        int n = items.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                double r1 = (double) items[j].profit / items[j].weight;
                double r2 = (double) items[j + 1].profit / items[j + 1].weight;
                if (r1 < r2) {
                    // Swap items[j] and items[j + 1]
                    Item temp = items[j];
                    items[j] = items[j + 1];
                    items[j + 1] = temp;
                }
            }
        }
    }

    // Method to get maximum profit
    private static double getMaxProfit(Item[] items, int capacity) {
        // Sort items by profit-to-weight ratio using Bubble Sort
        bubbleSort(items);

        double totalProfit = 0;

        for (Item item : items) {
            int curWeight = item.weight;
            int curProfit = item.profit;

            if (capacity - curWeight >= 0) {
                // This item can be fully taken
                capacity -= curWeight;
                totalProfit += curProfit;
            } else {
                // This item can only be taken fractionally
                double fraction = ((double) capacity / curWeight);
                totalProfit += (curProfit * fraction);
                capacity = (int) (capacity - (curWeight * fraction));
                break; // Since knapsack is full
            }
        }

        return totalProfit;
    }

    public static void main(String[] args) {
        Item[] items = {
            new Item(60, 10),
            new Item(100, 20),
            new Item(120, 30)
        };
        int capacity = 50;

        double maxProfit = getMaxProfit(items, capacity);
        System.out.println("Maximum profit we can obtain = " + maxProfit);
    }
}
