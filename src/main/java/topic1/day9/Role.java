package topic1.day9;

public enum Role implements Permission {
    ADMIN{
        @Override
        public boolean canDelete() {
            return true;
        }
    },
    USER{
        @Override
        public boolean canDelete() {
            return false;
        }
    },
    GUEST{
        @Override
        public boolean canDelete() {
            return false;
        }
    };


}
