package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Ladder {
    private final List<Line> lines;
    private final int heightOfLadder;

    public Ladder(List<Line> lines, int heightOfLadder) {
        this.lines = lines;
        this.heightOfLadder = heightOfLadder;
    }

    public static Ladder of(List<Person> persons, int heightOfLine) {
        List<Line> lines = new ArrayList<>();
        for (Person person : persons) {
            if (lines.size() > 0 && persons.size()-1 != lines.size()) {
                lines.add(Line.of(person, lines.get(lines.size() - 1)));
            } else if (lines.size() == 0) {
                lines.add(Line.first(person, heightOfLine));
            } else if (lines.size() == persons.size() - 1) {
                lines.add(Line.last(person, heightOfLine));
            }
        }
        return new Ladder(lines, heightOfLine);
    }

    public int getHeightOfLadder() {
        return heightOfLadder;
    }

    public List<Line> getLines() {
        return lines;
    }
}
