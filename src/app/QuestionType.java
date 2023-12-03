package app;

public enum QuestionType {
        ALL("All"), BOOL("True/False"), MULTI("Multiple Choice");

        public final String name;

        QuestionType(String name) {
                this.name = name;
        }

        public static QuestionType getByName(String name) {
                for(QuestionType v : values()){
                        if( v.name.equals(name)){
                                return v;
                        }
                }
                return null;
        }
}
