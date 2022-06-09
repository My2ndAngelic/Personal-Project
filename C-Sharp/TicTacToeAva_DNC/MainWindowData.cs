using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.ComponentModel;

namespace TicTacToeAva_DNC
{
    public sealed class MainWindowData : INotifyPropertyChanged
    {
        public ObservableCollection<string> TListMoveHistory { get; }

        public MainWindowData()
        {
            TListMoveHistory = new ObservableCollection<string>();
        }

        public event PropertyChangedEventHandler? PropertyChanged;
    }
}