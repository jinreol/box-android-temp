package com.example.sunflower.ui.garden

import androidx.activity.compose.ReportDrawn
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.sunflower.R
import com.example.sunflower.data.PlantAndGardenPlantings
import com.example.sunflower.viewmodels.GardenPlantingListViewModel

@Composable
fun GardenScreen(
    gardenPlants: List<PlantAndGardenPlantings>
) {
    if (gardenPlants.isEmpty()) {
        EmptyGarden()
    } else {
        Text("text2")
    }
}

@Composable
fun EmptyGarden() {

    val viewModel: GardenPlantingListViewModel = hiltViewModel()

    ReportDrawn()
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(id = R.string.garden_empty),
            style = MaterialTheme.typography.headlineSmall
        )
        Button(
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primaryContainer),
            shape = RoundedCornerShape(
                topStart = 0.dp,
                topEnd = dimensionResource(id = R.dimen.button_corner_radius),
                bottomStart = dimensionResource(id = R.dimen.button_corner_radius),
                bottomEnd = 0.dp
            ),
            onClick = { viewModel.testPrint() }
        ) {
            Text(
                color = MaterialTheme.colorScheme.primary,
                text = stringResource(id = R.string.add_plant)
            )
        }
    }
}