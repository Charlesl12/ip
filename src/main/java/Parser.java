public class Parser {

    public enum CommandType {
        TODO, DEADLINE, EVENT, LIST, DELETE, MARK, UNMARK, BYE, UNKNOWN;

        public static CommandType fromString(String str) {
            try {
                return CommandType.valueOf(str.toUpperCase());
            } catch (IllegalArgumentException e) {
                return UNKNOWN;
            }
        }
    }

    public static Command parse(String input) throws ClovisException {
        String[] splitInput = input.split(" ", 2);
        CommandType commandType = CommandType.fromString(splitInput[0]);
        String args = splitInput.length > 1 ? splitInput[1] : "";

        switch (commandType) {
            case TODO:
                if (args.isEmpty()) {
                    throw new ClovisException("A description is required for a todo.");
                }
                return new AddToDoCommand(args);
            case DEADLINE:
                String[] splitArgsDeadline = args.split("/by ", 2);
                if (splitArgsDeadline[0].isEmpty() || splitArgsDeadline[1].isEmpty()) {
                    throw new ClovisException("A description and a /by date are required for a deadline.");
                }
                return new AddDeadlineCommand(splitArgsDeadline[0], splitArgsDeadline[1]);
            case EVENT:
                String[] splitArgsEvent = args.split("/from | /to ");
                if (splitArgsEvent[0].isEmpty() || splitArgsEvent[1].isEmpty() || splitArgsEvent[2].isEmpty()) {
                    throw new ClovisException("A description, a /from date and, a /to date " +
                            "are required for an event is required for an event.");
                }
                return new AddEventCommand(splitArgsEvent[0], splitArgsEvent[1], splitArgsEvent[2]);
            case LIST:
                return new ListCommand();
            case MARK:
                return new MarkCommand(Integer.parseInt(args));
            case UNMARK:
                return new UnmarkCommand(Integer.parseInt(args));
            case DELETE:
                return new DeleteCommand(Integer.parseInt(args));
            case BYE:
                return new ExitCommand();
            default:
                throw new ClovisException("I have no idea what that means...");
        }
    }
}
