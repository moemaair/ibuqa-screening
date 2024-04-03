package com.ibuqa.screening

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldColors
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Comment
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.rounded.Comment
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.Person2
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.ibuqa.screening.data.DateUtil
import com.ibuqa.screening.domain.UserIssue
import com.ibuqa.screening.presentation.DropdownSortBy
import com.ibuqa.screening.presentation.DropdownState
import com.ibuqa.screening.presentation.MainViewModel
import com.ibuqa.screening.presentation.SearchAndFilterScreen
import com.ibuqa.screening.ui.theme.IbuqascreeningTheme
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel = hiltViewModel<MainViewModel>()
            val state by viewModel.state.collectAsState()
            IbuqascreeningTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFFE9F0F5)
                ) {
                    Home(
                        state = state
                    )


                }
            }
        }
    }
}



@Composable
fun Home(
    state: MainViewModel.IssueState,

) {
    var viewModel: MainViewModel = hiltViewModel()
    var showSortByDropdown by remember { mutableStateOf(false) }
    var showStateDropdown by remember { mutableStateOf(false) }
    val isVisible by remember {
        derivedStateOf {
            viewModel.searchQuery.value.isNotBlank()
        }
    }
    Column(Modifier.fillMaxSize()) {
        // First Column with 30% height
        Box(
            modifier = Modifier
                .weight(0.3f)
                .fillMaxWidth()
                .background(Color.White)
                .fillMaxHeight()
                //.padding(15.dp)
        ) {
            Column(modifier = Modifier.fillMaxHeight(),
                verticalArrangement = Arrangement.SpaceBetween
                ) {
                SearchAndFilterScreen()
                TextField(
                        value = viewModel.searchQuery.value.trim(),
                        onValueChange = viewModel::onSearch,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 15.dp),
                        shape = RoundedCornerShape(percent = 50),
                        placeholder = { Text(text = "example: 'facebook/react' ", fontSize = 13.sp)},
                        leadingIcon = {
                            Icon(imageVector = Icons.Default.Search, contentDescription = "", tint = Color(0xFF2452C9))
                        },
                        colors = TextFieldDefaults.textFieldColors(
                            backgroundColor = Color(0xFFd3eaf2),// Change background color here
                            focusedIndicatorColor = Color.Transparent, // Set focused indicator color to transparent
                            unfocusedIndicatorColor = Color.Transparent // Set unfocused indicator color to transparent
                        )
                        ,
                        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
                        keyboardActions = KeyboardActions(onDone = { /* TODO: Handle Done action */ })

                )
                Spacer(modifier = Modifier.height(10.dp))
                Row (modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 15.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    TextButton(onClick = {
                        showSortByDropdown = true
                    }) {
                        Column {
                            Row{
                                Text(text = "Sort by", style = androidx.compose.material3.MaterialTheme.typography.titleMedium, color = Color(0xFF2452C9))
                                Icon(imageVector = Icons.Default.ArrowDropDown, contentDescription = "")
                            }
                            if (showSortByDropdown) {
                                DropdownSortBy()
                            }

                        }
                    }
                    TextButton(onClick = {
                        showStateDropdown = true
                    }) {
                        Column {
                            Row{
                                Text(text = "State", style = androidx.compose.material3.MaterialTheme.typography.titleMedium, color = Color(0xFF2452C9))
                                Icon(imageVector = Icons.Default.ArrowDropDown, contentDescription = "")
                            }
                            if (showStateDropdown) {
                                DropdownState(

                                )
                            }

                        }

                    }



                }
            }
            
        }
        Spacer(modifier = Modifier.height(20.dp))
        // First Column with 70% height

        Box(
            modifier = Modifier
                .weight(0.7f) // 70% width
                .fillMaxHeight()
        ) {
            Box(modifier = Modifier
                .fillMaxSize()
            ){
                if(state.isLoading ) {
                    CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                }
                if(!isVisible){
                    Text(text = "Try searching for a Github Repository",
                        //color = if(isSystemInDarkTheme()) MaterialTheme.colors.primary else Color.LightGray,
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.TopCenter)
                            .padding(top = 150.dp),
                        textAlign = TextAlign.Center, fontSize = 14.sp)
                }
            }

            LazyColumn(
                modifier = Modifier.fillMaxSize()

            ) {
                items(state.issues) { issue ->
                    IssueItem(
                        issue = issue,
                        modifier = Modifier
                            .fillMaxWidth()

                    )
                    Spacer(modifier = Modifier.height(20.dp))

                }
            }


        }


    }




}


@Composable
private fun IssueItem(
    issue: UserIssue,
    modifier: Modifier
) {
    var createdAtModified = DateUtil(issue.createdAt.toString())

    Column(
        modifier = Modifier
            .background(Color.White)
            .fillMaxWidth()
            .padding(30.dp)
    ) {
        Row (
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Text(text = "Opened at $createdAtModified", color = Color.Gray,fontWeight = FontWeight.SemiBold)
            StateTagButton(
                text = issue.state
            )

        }
        Spacer(modifier = Modifier.height(10.dp))
        Column(
            modifier = Modifier

        ) {
            Text(text = issue.title, style = androidx.compose.material3.MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(5.dp))
            Text(text = issue.body.toString())
        }
        Spacer(modifier = Modifier.height(30.dp))
        Row (
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ){

            Row (horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically){
                Icon(imageVector = Icons.Rounded.Person2, contentDescription = "")
                Spacer(modifier = Modifier.width(6.dp))
                Text(text = issue.author)
            }

            Row (horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically){
                Icon(imageVector = Icons.Rounded.Comment, contentDescription = "")
                Spacer(modifier = Modifier.width(6.dp))
                Text(text = "${issue.commentsCount.toString()} comments")
            }

        }

    }



}

@Composable
fun StateTagButton(
    text: String,
    modifier: Modifier = Modifier,
    backgroundColor: Color = Color(0xFF2452C9),
    contentColor: Color = Color.White,
    shape: Shape = RoundedCornerShape(percent = 50)
) {
    Button(
        onClick = {},
        modifier = modifier.padding(horizontal = 2.dp, vertical = 2.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColor,
            contentColor = contentColor

        ),
        shape = shape,
        contentPadding = PaddingValues(horizontal = 10.dp, vertical = 2.dp)
    ) {
        Text(text = text,  fontSize = 11.sp , color = Color.White, style = androidx.compose.material3.MaterialTheme.typography.bodySmall)
    }
}




//@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    IbuqascreeningTheme {
        //Home()
    }
}