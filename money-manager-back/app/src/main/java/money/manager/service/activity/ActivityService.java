package money.manager.service.activity;
import money.manager.service.activity.dto.InsertActivityInputDto;
import money.manager.service.activity.dto.InsertActivityOutputDto;
import money.manager.service.activity.dto.ListActivitiesOutputDto;

import java.util.List;

public interface ActivityService {
    public InsertActivityOutputDto insertActivity(final InsertActivityInputDto anInput);
    public void removeActivity(final String anId);
    public List<ListActivitiesOutputDto> listActivities();
    public float calculateBalance();

}
