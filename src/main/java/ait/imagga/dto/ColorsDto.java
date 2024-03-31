package ait.imagga.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class ColorsDto {
    private List<ColorDto> backgroundColors;
    private double colorPercentThreshold;
    private int colorVariance;
    private List<ColorDto> foregroundColors;
    private List<ColorDto> imageColors;
    private double objectPercentage;
}
