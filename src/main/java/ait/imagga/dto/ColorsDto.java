package ait.imagga.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class ColorsDto {
    private List<ColorDto> background_colors;
    private double color_percent_threshold;
    private int color_variance;
    private List<ColorDto> foreground_colors;
    private List<ColorDto> image_colors;
    private double object_percentage;
}
