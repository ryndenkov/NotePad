package com.ryndenkov.notepad.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ryndenkov.notepad.presentation.navigation.NavGraph
import com.ryndenkov.notepad.presentation.screens.creation.CreateNoteScreen
import com.ryndenkov.notepad.presentation.screens.editing.EditNoteScreen
import com.ryndenkov.notepad.presentation.screens.notes.NotesScreen
import com.ryndenkov.notepad.presentation.ui.theme.NotePadTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NotePadTheme {
                NavGraph()
            }
        }
    }
}