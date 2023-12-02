package app;

public enum Category {
    AnyCategory(0, "any"),
    General(9, "General Knowledge"),
    Books(10, "Entertainment: Books"),
    Film(11, "Entertainment: Film"),
    Music(12, "Entertainment: Music"),
    Musicals(13, "Entertainment: Musicals & Theatres"),
    Television(14, "Entertainment: Television"),
    Video(15, "Entertainment: Video Games"),
    Board(16, "Entertainment: Board Games"),
    Nature(17, "Science & Nature"),
    Computers(18, "Science: Computers"),
    Mathematics(19, "Science: Mathematics"),
    Mythology(20, "Mythology"),
    Sports(21, "Sports"),
    Geography(22, "Geography"),
    History(23, "History"),
    Politics(24, "Politics"),
    Art(25, "Art"),
    Celebrities(26, "Celebrities"),
    Animals(27, "Animals"),
    Vehicles(28, "Vehicles"),
    Comics(29, "Entertainment: Comics"),
    Gadgets(30, "Science: Gadgets"),
    Japanese(31, "Entertainment: Japanese Anime & Manga"),
    Cartoon(32, "Entertainment: Cartoon & Animations");

    public final int value;
    public final String name;

    Category(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public String getName() { return this.name; }

    public static Category getByName(String name) {
        for(Category v : values()){
            if( v.name.equals(name)){
                return v;
            }
        }
        return null;
    }
}
