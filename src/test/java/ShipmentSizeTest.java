import com.trendyol.shipment.ShipmentSize;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ShipmentSizeTest {

    @Test
    void shouldReturnNextShipmentSize() {
        assertEquals(ShipmentSize.MEDIUM, ShipmentSize.SMALL.getNextSize());
        assertEquals(ShipmentSize.LARGE, ShipmentSize.MEDIUM.getNextSize());
        assertEquals(ShipmentSize.X_LARGE, ShipmentSize.LARGE.getNextSize());
    }

    @Test
    void shouldReturnXLargeWhenSizeIsXLarge() {
        assertEquals(ShipmentSize.X_LARGE, ShipmentSize.X_LARGE.getNextSize());
    }

}
