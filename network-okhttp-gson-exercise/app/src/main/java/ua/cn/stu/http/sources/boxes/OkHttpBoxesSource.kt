package ua.cn.stu.http.sources.boxes

import kotlinx.coroutines.delay
import okhttp3.Request
import ua.cn.stu.http.app.model.boxes.BoxesSource
import ua.cn.stu.http.app.model.boxes.entities.BoxAndSettings
import ua.cn.stu.http.app.model.boxes.entities.BoxesFilter
import ua.cn.stu.http.sources.base.BaseOkHttpSource
import ua.cn.stu.http.sources.base.OkHttpConfig
import ua.cn.stu.http.sources.boxes.entities.UpdateBoxRequestEntity

// todo #7: implement methods:
//          - getBoxes() -> for fetching boxes data
class OkHttpBoxesSource(
    config: OkHttpConfig
) : BaseOkHttpSource(config), BoxesSource {

    override suspend fun setIsActive(boxId: Long, isActive: Boolean) {
        val updateBoxRequestEntity = UpdateBoxRequestEntity(isActive = isActive)
        val request = Request.Builder()
            .put(updateBoxRequestEntity.toJsonRequestBody())
            .endpoint("/boxes/${boxId}")
            .build()
        client.newCall(request).suspendEnqueue()
    }

    override suspend fun getBoxes(boxesFilter: BoxesFilter): List<BoxAndSettings> {
        delay(500)
        // Call "GET /boxes?active=true" if boxesFilter = ONLY_ACTIVE.
        // Call "GET /boxes" if boxesFilter = ALL.
        // Hint: use TypeToken for converting server response into List<GetBoxResponseEntity>
        // Hint: use GetBoxResponseEntity.toBoxAndSettings for mapping GetBoxResponseEntity into BoxAndSettings
        TODO()
    }
}