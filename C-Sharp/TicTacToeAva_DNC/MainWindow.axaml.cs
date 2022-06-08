using System;
using System.IO;
using System.Linq;
using System.Reflection;
using System.Threading.Tasks;
using Avalonia;
using Avalonia.Controls;
using Avalonia.Interactivity;
using Avalonia.Layout;
using Avalonia.Media;
using Avalonia.Threading;
using TicTacToeBackendLibrary;
using MessageBox.Avalonia;
using MessageBox.Avalonia.DTO;
using MessageBox.Avalonia.Enums;

namespace TicTacToeAva_DNC
{
    public partial class MainWindow : Window
    {
        private const int BoardSize = 3;
        private readonly TicTacToe ttt = new TicTacToe(BoardSize);
        private string? folderPath = $"{Environment.CurrentDirectory}";
        private bool isComputerTurn;
        private bool isComputerVsComputerMode;
        private bool isComputerVsHumanMode;
        private bool p1Turn = true;

        public MainWindow()
        {
            InitializeComponent();
            NewGame();
            InitializeGUI();
            InitializeBoard();
            DataContext = ttt;
        }

        /// <summary>
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void ButtonGameBoard_OnClick(object sender, RoutedEventArgs e)
        {
            Button button = (Button) sender;

            // Get the position of the button
            int column = Grid.GetColumn(button);
            int row = Grid.GetRow(button);

            // Add move to the database
            if (!ttt.Move(row, column)) // Move method returns false if the move is invalid
                return;

            // Color the button
            if (p1Turn)
            {
                button.Content = ttt.P1Symbol;
                button.Foreground = Brushes.Red;
                p1Turn = false;
            }
            else
            {
                button.Content = ttt.P2Symbol;
                button.Foreground = Brushes.Blue;
                p1Turn = true;
            }

            // Disable the button
            button.IsEnabled = false;

            // Add move history to the list
            // ListMoveHistory.Items.Add($"{(p1Turn ? ttt.P1Name : ttt.P2Name)} puts {(p1Turn ? ttt.P1Symbol : ttt.P2Symbol)} into row {row} column {column}.");
            // ListMoveHistory.DataContext.
            CheckGameStatus(); // Check the game status

            switch (isComputerVsComputerMode) // Check if computer vs computer mode
            {
                case false when !isComputerVsHumanMode: // If computer vs computer
                    return;
                case false: // If computer vs human
                    isComputerTurn = !isComputerTurn;
                    break;
                default: // If computer vs computer
                    isComputerTurn = true;
                    break;
            }

            ComputerMove(); // Computer move
        }

        /// <summary>
        ///     Handling the event when computer move is made
        /// </summary>
        private void ComputerMove()
        {
            if (!isComputerTurn || ttt.IsGameOver()) return; // If computer is not playing or game is over, do nothing

            (int row, int column) = ttt.RandomComputerMoveIntegerTuple(); // Get computer move

            // Click the button from the computer's move
            FieldOfPlay.Children.OfType<Button>().First(b => b.Name == $"Button_{row}_{column}")
                .RaiseEvent(new RoutedEventArgs(Button.ClickEvent)); // Click the button
        }

        /// <summary>
        ///     Check the game status and update the UI
        /// </summary>
        private void CheckGameStatus()
        {
            if (!ttt.IsGameOver())
            {
                GameStatus.Text = $"Ongoing between {ttt.P1Name}: {ttt.P1Symbol} and {ttt.P2Name}: {ttt.P2Symbol}";
                return;
            }

            GameStatus.Text = $"Game over. {ttt.GetWinner()} wins!";
            // ListMoveHistory.Items.Add($"Match length: {ttt.EndTime.Subtract(ttt.StartTime).TotalSeconds:F} seconds");
            foreach (Button button in FieldOfPlay.Children.OfType<Button>()) button.IsEnabled = false;

            // Auto write to file could be done here
            // Add a checkbox to enable/disable auto-write to file. Maybe implemented in a later version.
            // Not now
        }

        /// <summary>
        ///     Update the timer
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void dispatcherTimer_Tick(object? sender, EventArgs e)
        {
            TimeInfo.Text =
                $@"Date: {DateTime.Now:yyyy-MM-dd}
Local time: {DateTime.Now:HH:mm:ss}
Match length: {(ttt.TurnHistory.Count == 0 ? 0 : ttt.IsGameOver() ? ttt.EndTime.Subtract(ttt.StartTime).TotalMilliseconds / 1000 : DateTime.Now.Subtract(ttt.StartTime).TotalMilliseconds / 1000):F}";
        }

        /// <summary>
        ///     Board initialization
        /// </summary>
        private void InitializeBoard()
        {
            // Clear play area
            FieldOfPlay.Children.Clear();
            FieldOfPlay.RowDefinitions.Clear();
            FieldOfPlay.ColumnDefinitions.Clear();

            // Initialize row and column definitions for play area n x n
            for (int i = 0; i < ttt.BoardSize; i++)
            {
                RowDefinition rowStar = new RowDefinition
                {
                    Height = new GridLength(1, GridUnitType.Star)
                };
                FieldOfPlay.RowDefinitions.Add(rowStar);
                ColumnDefinition columnStar = new ColumnDefinition
                {
                    Width = new GridLength(1, GridUnitType.Star)
                };
                FieldOfPlay.ColumnDefinitions.Add(columnStar);
            }

            // Initialize n x n buttons for play area
            for (int i = 0; i < ttt.BoardSize; i++)
            for (int j = 0; j < ttt.BoardSize; j++)
            {
                Button button = new Button
                {
                    Name = $"Button_{i}_{j}",
                    FontSize = 30,
                    FontWeight = FontWeight.Bold,
                    Content = "",
                    IsEnabled = true,
                    Background = Brushes.Azure,
                    BorderBrush = Brushes.Black,
                    Foreground = Brushes.White,
                    HorizontalAlignment = HorizontalAlignment.Stretch,
                    VerticalAlignment = VerticalAlignment.Stretch,
                    Margin = Thickness.Parse("10,10,10,10"),
                    HorizontalContentAlignment = HorizontalAlignment.Center,
                    VerticalContentAlignment = VerticalAlignment.Center,
                };
                button.Click += ButtonGameBoard_OnClick;
                Grid.SetRow(button, i);
                Grid.SetColumn(button, j);
                FieldOfPlay.Children.Add(button);
            }

            // Match history list
            CheckGameStatus();
        }

        /// <summary>
        ///     Initialize the program
        /// </summary>
        private void InitializeGUI()
        {
            DispatcherTimer dt = new DispatcherTimer
            {
                Interval = new TimeSpan(0, 0, 0, 0, 10)
            };
            dt.Tick += dispatcherTimer_Tick;
            dt.Start();
            SysInfo.Text = $"Save folder: {folderPath}";
            Title =
                $"{((AssemblyProductAttribute) Attribute.GetCustomAttribute(Assembly.GetExecutingAssembly(), typeof(AssemblyProductAttribute), false)).Product}";
        }

        /// <summary>
        ///     Show about dialog
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private async void MenuAbout_OnClick(object sender, RoutedEventArgs e)
        { 
            await new AboutWindow().ShowDialog(this);
        }

        /// <summary>
        ///     Just exit the application
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void MenuExit_OnClick(object sender, RoutedEventArgs e)
        {
            Environment.Exit(0);
        }

        /// <summary>
        ///     Initialize new game: Computer as player 1 and computer as player 2
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void MenuNewEvE_OnClick(object sender, RoutedEventArgs e)
        {
            NewGame();
            ttt.P1Name = "Computer 1";
            ttt.P2Name = "Computer 2";
            isComputerVsHumanMode = false;
            isComputerTurn = true;
            isComputerVsComputerMode = true;
            InitializeBoard();
            CheckGameStatus();
            ComputerMove();
        }

        /// <summary>
        ///     Initialize new game: Computer as player 1 and human as player 2
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void MenuNewEvP_OnClick(object sender, RoutedEventArgs e)
        {
            NewGame();
            ttt.P1Name = "Computer";
            ttt.P2Name = "Player 2";
            isComputerVsHumanMode = true;
            isComputerTurn = true;
            isComputerVsComputerMode = false;
            InitializeBoard();
            CheckGameStatus();
            ComputerMove();
        }

        /// <summary>
        ///     Initialize new game: Human as player 1 and computer as player 2
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void MenuNewPvE_OnClick(object sender, RoutedEventArgs e)
        {
            NewGame();
            ttt.P1Name = "Player 1";
            ttt.P2Name = "Computer";
            isComputerVsHumanMode = true;
            isComputerTurn = false;
            isComputerVsComputerMode = false;
            InitializeBoard();
            CheckGameStatus();
        }

        /// <summary>
        ///     Initialize new game: Human as player 1 and human as player 2
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void MenuNewPvP_OnClick(object sender, RoutedEventArgs e)
        {
            NewGame();
            ttt.P1Name = "Player 1";
            ttt.P2Name = "Player 2";
            isComputerVsHumanMode = false;
            isComputerTurn = false;
            isComputerVsComputerMode = false;
            InitializeBoard();
        }

        /// <summary>
        ///     Save game
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void MenuSave_OnClick(object sender, RoutedEventArgs e)
        {
            try
            {
                if (ttt.IsGameOver()) // Game finished
                {
                    File.WriteAllText(
                        $"{folderPath}/{new DateTimeOffset(ttt.StartTime).ToUnixTimeMilliseconds()}.mhf",
                        ttt.ToString()); // Write to file
                    MessageBoxManager.GetMessageBoxStandardWindow(new MessageBoxStandardParams()
                    {
                        ButtonDefinitions = ButtonEnum.Ok,
                        ContentTitle = "Save",
                        ContentMessage = $"Game saved successfully.",
                        WindowIcon = Icon,
                        Icon = MessageBox.Avalonia.Enums.Icon.Info,
                    }).Show();
                }
                else // Game not finished
                {
                    MessageBoxManager.GetMessageBoxStandardWindow(new MessageBoxStandardParams()
                    {
                        ButtonDefinitions = ButtonEnum.Ok,
                        ContentTitle = "Error",
                        ContentMessage = "Please finish the game before saving",
                        WindowIcon = Icon,
                        Icon = MessageBox.Avalonia.Enums.Icon.Error,
                    }).Show();
                }
            }
            catch (DirectoryNotFoundException) // If saving on a network/flash drive and the connection lost
            {
                MessageBoxManager.GetMessageBoxStandardWindow(new MessageBoxStandardParams()
                {
                    ButtonDefinitions = ButtonEnum.Ok,
                    ContentTitle = "Error",
                    ContentMessage = $"{folderPath} is not found. Please select another folder and try again.",
                    WindowIcon = Icon,
                    Icon = MessageBox.Avalonia.Enums.Icon.Error,
                }).Show();
            }
            catch (IOException ex) // If error occured during saving
            {
                MessageBoxManager.GetMessageBoxStandardWindow(new MessageBoxStandardParams()
                {
                    ButtonDefinitions = ButtonEnum.Ok,
                    ContentTitle = "Error",
                    ContentMessage = $"{ex.Message}",
                    WindowIcon = Icon,
                    Icon = MessageBox.Avalonia.Enums.Icon.Error,
                }).Show();
            }
            catch (UnauthorizedAccessException) // If you cannot write match history due to lack of permission
            {
                MessageBoxManager.GetMessageBoxStandardWindow(new MessageBoxStandardParams()
                {
                    ButtonDefinitions = ButtonEnum.Ok,
                    ContentTitle = "Error",
                    ContentMessage = $"{folderPath} is not accessible. Please make sure you have permission to write to this folder.",
                    WindowIcon = Icon,
                    Icon = MessageBox.Avalonia.Enums.Icon.Error,
                }).Show();
            }
            // catch (Exception ex) // Other error, just catch it, I do not know what else can happen
            // {
            //     MessageBox.Show($@"{ex.Message}", "Error", MessageBoxButton.OK, MessageBoxImage.Error);
            // }
        }

        /// <summary>
        /// Select folder to save match history
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="routedEventArgs"></param>
        private async void MenuSelectFolder_OnClick(object sender, RoutedEventArgs routedEventArgs)
        {
            folderPath = await new OpenFolderDialog().ShowAsync(this) ?? folderPath;
            // Do I need to check for write permission before changing the folder?
            SysInfo.Text = $"Save folder: {folderPath}";
        }

        /// <summary>
        ///     New game
        /// </summary>
        private void NewGame()
        {
            ttt.Reset();
            p1Turn = true;
            // ListMoveHistory.Items.Clear();
        } 
    }
}