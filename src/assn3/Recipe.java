/*
 * Student Name: Nwachukwu Ebube 041165175 
 * Professor Name: Amal Ibrahim
 * Course Section: 302
 * Assignment: 3
 * this class contains ingredients needed for recipes. 
 * It also includes a method that sums up the amount of times a certain recipe was ordered
 */


package assn3;

/**
 * this class contains ingredients needed for recipes. 
 * It also includes a method that sums up the amount of times a certain recipe was ordered
 */
public class Recipe {
	/**
	 * name of the recipe
	 */
    private String name;
    /**
     * amount of eggs needed
     */
    private float eggs;
    /**
     * amount of yeast needed
     */
    private float yeast;
    /**
     * amount of flour needed
     */
    private float flour;
    /**
     * amount of sugar needed
     */
    private float sugar;
    /**
     * amount of butter needed
     */
    private float butter;
    /**
     * amount of a bread ordered
     */
    private int quantityOrdered;

    /**
     * default constructor
     * @param name name of the recipe
     * @param eggs amount of eggs needed
     * @param yeast amount of yeast needed
     * @param flour amount of flour needed
     * @param sugar amount of sugar needed
     * @param butter amount of butter needed
     */
    public Recipe(String name, float eggs, float yeast, float flour, float sugar, float butter) {
        this.name = name;
        this.eggs = eggs;
        this.yeast = yeast;
        this.flour = flour;
        this.sugar = sugar;
        this.butter = butter;
        this.quantityOrdered = 0;
    }

    /**
     * returns name of the recipe
     * @return name of recipe
     */
    public String getName() {
        return name;
    }

    /**
     * sets the name of recipe
     * @param name name of recipe
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * returns amount of eggs needed
     * @return amount of eggs needed
     */
    public float getEggs() {
        return eggs;
    }

    /**
     * sets the amount of eggs needed
     * @param eggs amount of eggs needed
     */
    public void setEggs(float eggs) {
        this.eggs = eggs;
    }

    /**
     * returns amount of yeast needed
     * @return amount of yeast needed
     */
    public float getYeast() {
        return yeast;
    }

    /**
     * sets the amount of yeast needed
     * @param yeast amount of yeast needed
     */
    public void setYeast(float yeast) {
        this.yeast = yeast;
    }

    /**
     * returns amount of flour needed
     * @return amount of flour needed
     */
    public float getFlour() {
        return flour;
    }

    /**
     * sets amount of flour needed
     * @param flour amount of flour needed
     */
    public void setFlour(float flour) {
        this.flour = flour;
    }

    /**
     * returns amount of sugar needed
     * @return amount of sugar needed
     */
    public float getSugar() {
        return sugar;
    }

    /**
     * sets the amount of sugar needed
     * @param sugar returns amount of sugar needed
     */
    public void setSugar(float sugar) {
        this.sugar = sugar;
    }

    /**
     * returns the amount of butter needed
     * @return the amount of butter needed
     */
    public float getButter() {
        return butter;
    }

    /**
     * sets the amount of butter needed
     * @param butter amount of butter needed
     */
    public void setButter(float butter) {
        this.butter = butter;
    }

    /**
     * returns the amount of bread ordered
     * @return amount of bread ordered
     */
    public int getQuantityOrdered() {
        return quantityOrdered;
    }

    /**
     * sets the amount of bread ordered
     * @param quantityOrdered amount of bread ordered
     */
    public void setQuantityOrdered(int quantityOrdered) {
        this.quantityOrdered = quantityOrdered;  
    }

    /**
     * adds up the amount of times a type of bread has been ordered
     * @param quantity total number of orders for a type of bread
     */
    public void addQuantityOrdered(int quantity) {
        if (quantity >= 0) {
            this.quantityOrdered += quantity;
        }
    }
}
