package racinggame.model;

import java.util.List;

public interface RacingGameService {
    void init(Cars cars);

    List<String> racing();

    RacingReport end();
}
