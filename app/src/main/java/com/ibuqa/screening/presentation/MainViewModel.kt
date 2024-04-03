package com.ibuqa.screening.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ibuqa.screening.domain.GetUserIssuesUseCase
import com.ibuqa.screening.domain.UserIssue
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getUserIssuesUseCase: GetUserIssuesUseCase

): ViewModel(){

    private val _state = MutableStateFlow(IssueState())
    val state = _state.asStateFlow()

    var _searchQuery = mutableStateOf("")
    var searchQuery: State<String> = _searchQuery

    init {

    }

    fun onSearch(query: String) {
        _searchQuery.value = query
        viewModelScope.launch {
            _state.update { it.copy(
                isLoading = true
            ) }
            _state.update { it.copy(
                issues = getUserIssuesUseCase.execute(
                    query
                ),
                isLoading = false
            ) }
        }


    }

    data class IssueState(
        val issues: List<UserIssue> = emptyList(),
        val isLoading: Boolean = false,
    )



}