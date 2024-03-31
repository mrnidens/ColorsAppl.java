package ait.imagga;

import ait.imagga.dto.ColorDto;
import ait.imagga.dto.ColorsDto;
import ait.imagga.dto.ResponseDto;
import ait.imagga.dto.ResultDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

public class ColorsAppl {
    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic YWNjX2U1ODc5ZWNiMGQ5OGRkZTpjZGQxYzQxMDI0MDMxZDJhZTYzY2RmZmQ0MGUyM2Y5Mg==");

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("https://api.imagga.com/v2/colors")
                .queryParam("image_url", "https://www.ludego.com/wp-content/uploads/2021/09/Born-schraek-1.png");

        URI url = builder.build().toUri();
        RequestEntity<String> request = new RequestEntity<>(headers, HttpMethod.GET, url);

        ResponseEntity<ResponseDto> response = restTemplate.exchange(request, ResponseDto.class);

        System.out.println(response.getStatusCode());
        System.out.println(response.getHeaders().get("Content-Type"));

        ResponseDto responseDto = response.getBody();
        if (responseDto != null) {
            ResultDto resultDto = responseDto.getResult();
            if (resultDto != null) {
                ColorsDto colorsDto = resultDto.getColors();
                if (colorsDto != null) {
                    printColors("Background Colors", colorsDto.getBackgroundColors());
                    printColors("Foreground Colors", colorsDto.getForegroundColors());
                    printColors("Image Colors", colorsDto.getImageColors());
                }
            }
        }
    }

    private static void printColors(String category, List<ColorDto> colors) {
        if (colors != null && !colors.isEmpty()) {
            System.out.println(category + ":");
            for (ColorDto color : colors) {
                System.out.println("  Color Name: " + color.getClosestPaletteColor());
                System.out.println("  Parent Color Name: " + color.getClosestPaletteColorParent());
                System.out.println("  Coverage Percent: " + color.getPercent());
                System.out.println(); // Для отделения информации о цветах
            }
        } else {
            System.out.println(category + ": No colors found.");
        }
    }
}
