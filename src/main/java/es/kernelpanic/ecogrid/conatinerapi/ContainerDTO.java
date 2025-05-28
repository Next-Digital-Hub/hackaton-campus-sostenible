package es.kernelpanic.ecogrid.conatinerapi;

import lombok.Data;

import java.util.List;
@Data
public class ContainerDTO {
    private String id;
    private List<HistoryEntry> history;

    @Data
    public static class HistoryEntry {
        private String timestamp;
        private int levelPercent;
    }
}