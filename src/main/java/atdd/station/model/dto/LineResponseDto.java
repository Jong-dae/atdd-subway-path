package atdd.station.model.dto;

import atdd.station.model.entity.Edge;
import atdd.station.model.entity.Line;
import atdd.station.model.entity.Station;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalTime;
import java.util.List;

@Getter
public class LineResponseDto {
    private long id;
    private String name;

    @JsonFormat(pattern = "HH:mm")
    private LocalTime startTime;

    @JsonFormat(pattern = "HH:mm")
    private LocalTime endTime;

    private int intervalTime;

    private List<StationSimpleDto> stations;

    public LineResponseDto() {
    }

    @Builder
    private LineResponseDto(long id, String name, LocalTime startTime, LocalTime endTime, int intervalTime, List<StationSimpleDto> stations) {
        this.id = id;
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
        this.intervalTime = intervalTime;
        this.stations = stations;
    }

    public static LineResponseDto of(final Line line, final List<Edge> newEdges, final List<Station> stations) {
        return LineDtoAssembler.assemble(line, newEdges, stations);
    }
}