package li.songe.gkd.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import li.songe.gkd.R
import li.songe.gkd.db.table.SubsItem

@Composable
fun SubsItemCard(
    data: SubsItem,
    onShareClick: (() -> Unit)? = null,
    onEditClick: (() -> Unit)? = null,
    onDelClick: (() -> Unit)? = null,
    onRefreshClick: (() -> Unit)? = null,
) {

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(8.dp)
            .alpha(if (data.enable) 1f else .3f),
    ) {
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = data.name,
                maxLines = 1,
                softWrap = false,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = data.updateUrl,
                maxLines = 1,
                softWrap = false,
                overflow = TextOverflow.Ellipsis
            )
        }
        Spacer(modifier = Modifier.width(5.dp))
        Image(
            painter = painterResource(R.drawable.ic_refresh),
            contentDescription = "refresh",
            modifier = Modifier
                .clickable {
                    onRefreshClick?.invoke()
                }
                .padding(4.dp)
                .size(20.dp)
        )
        Spacer(modifier = Modifier.width(5.dp))
        Image(
            painter = painterResource(R.drawable.ic_share),
            contentDescription = "share",
            modifier = Modifier
                .clickable {
                    onShareClick?.invoke()
                }
                .padding(4.dp)
                .size(20.dp)
        )
        Spacer(modifier = Modifier.width(5.dp))
        Image(
            painter = painterResource(R.drawable.ic_create_round),
            contentDescription = "edit",
            modifier = Modifier
                .clickable {
                    onEditClick?.invoke()
                }
                .padding(4.dp)
                .size(20.dp)
        )
        Spacer(modifier = Modifier.width(5.dp))
        Image(
            painter = painterResource(R.drawable.ic_del),
            contentDescription = "edit",
            modifier = Modifier
                .clickable {
                    onDelClick?.invoke()
                }
                .padding(4.dp)
                .size(20.dp)
        )
    }
}

@Preview
@Composable
fun PreviewSubscriptionItemCard() {
    Surface(modifier = Modifier.width(300.dp)) {
        SubsItemCard(
            SubsItem(
                filePath = "filepath",
                updateUrl = "https://raw.githubusercontents.com/lisonge/gkd-subscription/main/src/ad-startup.gkd.json",
                name = "APP工具箱"
            )
        )
    }
}