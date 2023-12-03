package app;

public enum QuestionDifficulty {
    ALL("All"), EASY("Easy"), MEDIUM("Medium"), HARD("Hard");

    public final String name;

    QuestionDifficulty(String name) {
        this.name = name;
    }

    public static QuestionDifficulty getByName(String name) {
        for(QuestionDifficulty v : values()){
            if( v.name.equals(name)){
                return v;
            }
        }
        return null;
    }
}
