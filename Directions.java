public enum Directions {
    E, N, NE, NW, S, SE, SW, W;

    @Override
    public String toString() {
        switch (this) {
            case E:
                return "East";
            case N:
                return "North";
            case NE:
                return "Northeast";
            case NW:
                return "Northwest";
            case S:
                return "South";
            case SE:
                return "Southeast";
            case SW:
                return "Southwest";
            case W:
                return "West";
            default:
                throw new IllegalArgumentException("Invalid direction");
        }
    }
}
