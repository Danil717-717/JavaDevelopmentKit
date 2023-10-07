package less2.common;

import java.awt.*;

/*
 Интерфейс помогает решить проблему единообразия
 поведения спрайтов и фона, при их различии в свойствах.
 То есть, сложилась ситуация в которой существует необходимость
 хранить в одном массиве объекты со схожим поведением,
  но наследовать их друг от друга не совсем логично
 */
public interface Interactable {
    void update(MainCanvas canvas, float deltaTime);
    void render(MainCanvas canvas, Graphics g);
}
