package clovis;

import clovis.command.*;

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
                try {
                    String[] splitArgsDeadline = args.split("/by ", 2);
                    return new AddDeadlineCommand(splitArgsDeadline[0], splitArgsDeadline[1]);
                } catch (ArrayIndexOutOfBoundsException e) {
                    throw new ClovisException("A description and a /by date are required for a deadline.");
                }
            case EVENT:
                try {
                    String[] splitArgsEvent = args.split("/from | /to ");
                    return new AddEventCommand(splitArgsEvent[0], splitArgsEvent[1], splitArgsEvent[2]);
                } catch (ArrayIndexOutOfBoundsException e) {
                    throw new ClovisException("A description, a /from date and, a /to date " +
                            "are required for an event is required for an event.");
                }
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
