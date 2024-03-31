package ait.imagga.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ColorDto {
    private int b;
    private String closestPaletteColor;
    private String closestPaletteColorHtmlCode;
    private String closestPaletteColorParent;
    private double closestPaletteDistance;
    private int g;
    private String htmlCode;
    private double percent;
    private int r;
}
