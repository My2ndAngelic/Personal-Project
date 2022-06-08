using System.Collections;
using System.Collections.Generic;

namespace TicTacToeBackendLibrary
{
    public class TicTacToeManager : IList<TicTacToe>
    {
        private readonly IList<TicTacToe> ticTacToes;

        public TicTacToeManager()
        {
            ticTacToes = new List<TicTacToe>();
        }

        public IList<TicTacToe> TicTacToes
        {
            get { return ticTacToes; }
        }

        public int Count
        {
            get { return ticTacToes.Count; }
        }

        public bool IsReadOnly
        {
            get { return ticTacToes.IsReadOnly; }
        }

        public TicTacToe this[int index]
        {
            get { return ticTacToes[index]; }
            set { ticTacToes[index] = value; }
        }

        public void Add(TicTacToe item)
        {
            ticTacToes.Add(item);
        }

        public void Clear()
        {
            ticTacToes.Clear();
        }

        public bool Contains(TicTacToe item)
        {
            return ticTacToes.Contains(item);
        }

        public void CopyTo(TicTacToe[] array, int arrayIndex)
        {
            ticTacToes.CopyTo(array, arrayIndex);
        }

        public IEnumerator<TicTacToe> GetEnumerator()
        {
            return ticTacToes.GetEnumerator();
        }

        IEnumerator IEnumerable.GetEnumerator()
        {
            return ((IEnumerable) ticTacToes).GetEnumerator();
        }

        public int IndexOf(TicTacToe item)
        {
            return ticTacToes.IndexOf(item);
        }

        public void Insert(int index, TicTacToe item)
        {
            ticTacToes.Insert(index, item);
        }

        public bool Remove(TicTacToe item)
        {
            return ticTacToes.Remove(item);
        }

        public void RemoveAt(int index)
        {
            ticTacToes.RemoveAt(index);
        }

        /// <summary>
        ///     Add list of ticTacToes to the TicTacToe manager
        /// </summary>
        /// <param name="toList">List of TicTacToe</param>
        public void Add(List<TicTacToe> toList)
        {
            toList.ForEach(ticTacToes.Add);
        }
    }
}