package cmps312.lab3.covidtrackerapp.Views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cmps312.lab3.covidtrackerapp.models.CovidStat

@Composable
fun CovidCard(countryData: CovidStat) {
    val context = LocalContext.current
    val country_img_id = context.resources.getIdentifier(
        "country",
        "drawable",
        context.packageName

    )
    val dead_img_id = context.resources.getIdentifier(
        "dead",
        "drawable",
        context.packageName

    )
    val activecases_img_id = context.resources.getIdentifier(
        "activecases",
        "drawable",
        context.packageName

    )
    val population_img_id = context.resources.getIdentifier(
        "population",
        "drawable",
        context.packageName

    )
    val recovered_img_id = context.resources.getIdentifier(
        "recovered",
        "drawable",
        context.packageName

    )
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(15.dp))
                .padding(8.dp),
            elevation = 15.dp
        ) {
            Column(
                modifier = Modifier.padding(10.dp)
            ) {
                Row() {
                    Column() {
                        Image(
                            painter = painterResource(id = country_img_id),
                            contentDescription = "Flag",
                            modifier = Modifier
                                .width(65.dp)
                                .height(65.dp)
                        )
                    }
                    Column() {
                        Text(text = "Country", fontSize = 15.sp, color = Color.Gray)
                        Text(
                            text = countryData.country,
                            fontSize = 30.sp,
                            color = Color.Black
                        )
                    }
                }
                Row() {
                    Column() {
                        Row {
                            Image(
                                painter = painterResource(id = population_img_id),
                                contentDescription = "Population",
                                modifier = Modifier
                                    .width(65.dp)
                                    .height(65.dp)
                            )
                            Spacer(modifier = Modifier.size(5.dp))
                            Column() {
                                Text(text = "Population", fontSize = 13.sp, color = Color.Gray)
                                Text(
                                    text = "%.1fM".format(countryData.population?.div(1000000.0)),
                                    fontSize = 20.sp,
                                    color = Color.Black
                                )
                            }
                        }
                    }
                    Column() {
                        Row {
                            Image(
                                painter = painterResource(id = activecases_img_id),
                                contentDescription = "Active Cases",
                                modifier = Modifier
                                    .width(65.dp)
                                    .height(65.dp)
                            )
                            Spacer(modifier = Modifier.size(5.dp))
                            Column() {
                                Text(text = "Active Cases", fontSize = 13.sp, color = Color.Gray)
                                Text(
                                    text = "%.1fK".format(countryData.activeCases?.div(1000.0)),
                                    fontSize = 20.sp,
                                    color = Color.Black
                                )
                            }
                        }
                    }
                }
                Row() {
                    Column() {
                        Row {
                            Image(
                                painter = painterResource(id = dead_img_id),
                                contentDescription = "Dead Cases",
                                modifier = Modifier
                                    .width(65.dp)
                                    .height(65.dp)
                            )
                            Spacer(modifier = Modifier.size(5.dp))
                            Column() {
                                Text(text = "Total Deaths", fontSize = 13.sp, color = Color.Gray)
                                Text(
                                    text = "%.1fK".format(countryData.totalDeaths?.div(1000.0)),
                                    fontSize = 20.sp,
                                    color = Color.Black
                                )
                            }
                        }
                    }
                    Column() {
                        Row {
                            Image(
                                painter = painterResource(id = recovered_img_id),
                                contentDescription = "Total Recovered",
                                modifier = Modifier
                                    .width(65.dp)
                                    .height(65.dp)
                            )
                            Spacer(modifier = Modifier.size(5.dp))
                            Column() {
                                Text(text = "Total Recovered", fontSize = 13.sp, color = Color.Gray)
                                Text(
                                    text = "%.1fK".format(countryData.totalRecovered?.div(1000.0)),
                                    fontSize = 20.sp,
                                    color = Color.Black
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}