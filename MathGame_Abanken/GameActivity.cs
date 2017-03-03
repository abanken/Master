using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

using Android.App;
using Android.Content;
using Android.OS;
using Android.Runtime;
using Android.Views;
using Android.Widget;

namespace MathGame_Abanken.Resources.layout
{

    [Activity(Label = "GameActivity")]
    public class GameActivity : Activity
    {
        protected override void OnCreate(Bundle savedInstanceState)
        {
            base.OnCreate(savedInstanceState);

            SetContentView(Resource.Layout.gameScreen);
           
           
            TextView number1 = FindViewById<TextView>(Resource.Id.number1);
            TextView number2 = FindViewById<TextView>(Resource.Id.number2);
            TextView operatorSign = FindViewById<TextView>(Resource.Id.operatorSign);
            Button answerBtn = FindViewById<Button>(Resource.Id.answerBtn);
            Button ScoreBtn = FindViewById<Button>(Resource.Id.ScoreBtn);
            EditText answer = FindViewById<EditText>(Resource.Id.answer);
            TextView incorrectAnswers = FindViewById<TextView>(Resource.Id.incorrectAnswers);
            TextView scores = FindViewById<TextView>(Resource.Id.score);

            Random rnd = new Random();
            int start1 = rnd.Next(1, 15);
            int start2 = rnd.Next(1, 15);
            double sum;
            int strike = 0;
            int score = 0;
            var c = 0;
            number2.Text = "" + start1;
            number1.Text = "" + start2;

            operatorSign.Text = "+" ;

            answerBtn.Click += (s, e) =>
            {
                answerBtn.Text = "Submit Answer";
                double ansED = Double.Parse(answer.Text);
                double snum = Double.Parse(incorrectAnswers.Text);
                if (snum < 4)
                {
                    if (c == 0)
                    {
                        sum = start1 + start2;
                        if (ansED == sum)
                        {
                            string toast = string.Format("correct");
                            Toast.MakeText(this, toast, ToastLength.Short).Show();
                            score++;
                          
                            scores.Text = "" + score;
                        }
                        else
                        {
                            string toast = string.Format("wrong: " + sum);
                            Toast.MakeText(this, toast, ToastLength.Short).Show();
                            strike++;
                            incorrectAnswers.Text = "" + strike;
                        }
                        c++;
                        operatorSign.Text = "-";
                    }
                    else if (c == 1)
                    {
                        sum = start1 - start2;
                        if (ansED == sum)
                        {
                            string toast = string.Format("correct");
                            Toast.MakeText(this, toast, ToastLength.Short).Show();
                            score++;
                            scores.Text = "" + score;
                        }
                        else
                        {
                            string toast = string.Format("wrong: " + sum);
                            Toast.MakeText(this, toast, ToastLength.Short).Show();
                            strike++;
                            incorrectAnswers.Text = "" + strike;
                        }
                        c++;
                        operatorSign.Text = "*";
                    }
                    else if (c == 2)
                    {
                        sum = start1 * start2;
                        if (ansED == sum)
                        {
                            string toast = string.Format("correct");
                            Toast.MakeText(this, toast, ToastLength.Short).Show();
                            score++;
                            scores.Text = "" + score;
                        }
                        else
                        {
                            string toast = string.Format("wrong: " + sum);
                            Toast.MakeText(this, toast, ToastLength.Short).Show();
                            strike++;
                            incorrectAnswers.Text = "" + strike;
                        }
                        c = 0;
                        operatorSign.Text = "+";
                    }
                    start1 = rnd.Next(1, 15);
                    start2 = rnd.Next(1, 15);
                    number2.Text = "" + start1;
                    number1.Text = "" + start2;
                }
                else
                {
                    string toast = string.Format("You lose");
                    Toast.MakeText(this, toast, ToastLength.Long).Show();
                    answerBtn.Enabled = false;

                    var highscores = Application.Context.GetSharedPreferences("High Scores", FileCreationMode.Private);
                    var scoreEdit = highscores.Edit();
                    string sscore = score.ToString();
                    scoreEdit.PutString("Score", sscore);
                    scoreEdit.Commit();

                }
            };
            ScoreBtn.Click += (s, e) =>
            {
                var intent = new Intent(this, typeof(ScoreActivity));
                StartActivity(intent);
            };
        }
    }
}