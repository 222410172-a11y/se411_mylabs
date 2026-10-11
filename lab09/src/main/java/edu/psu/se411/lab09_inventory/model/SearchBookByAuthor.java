package edu.psu.se411.lab09_inventory.model;

public class SearchBookByAuthor implements SearchStrategy<Item> {

    private String authorName;

    public SearchBookByAuthor(String authorName) {
        this.authorName = authorName;
    }

    @Override
    public boolean matches(Item item) {

        if (item instanceof Book) {
            Book book = (Book) item;

            return book.getAuthorName().equalsIgnoreCase(authorName);
        }

        return false;
    }
}