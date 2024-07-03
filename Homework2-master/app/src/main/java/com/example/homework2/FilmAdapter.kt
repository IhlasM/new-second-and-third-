package com.example.homework2
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

open class FilmAdapter : RecyclerView.Adapter<FilmAdapter.FilmViewHolder>()  {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FilmAdapter.FilmViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.film_item, parent, false)
        return FilmViewHolder(view)
    }

    override fun onBindViewHolder(holder: FilmAdapter.FilmViewHolder, position: Int) {
        val currentFilm = films[position]
        var filmname = currentFilm.name
        if(filmname.length > 15){
            filmname = filmname.substring(0, 15) + "..."
        }
        holder.filmTitle.text = filmname
        holder.yearTitle.text = currentFilm.year.toString()
        Picasso.get().load(currentFilm.cover).into(holder.filmImage)
        holder.itemView.setOnClickListener {
            holder.itemView.findNavController().navigate(
                resId = R.id.action_firstFragment_to_filmFragment,
                args = FilmFragment.bundle(
                    currentFilm.name,
                    currentFilm.year.toString(),
                    currentFilm.cover,
                    currentFilm.description
                )
            )
        }
    }

    private val films: MutableList<Film> = mutableListOf(
        Film(
            "Экстаз",
            2018,
            "https://www.kino-teatr.ru/movie/poster/131101/92169.jpg",
            "Из-за наркотика в выпивке вечеринка танцоров превращается в безумный хаос. Провокационный триллер Гаспара Ноэ"
        ),
        Film(
            "Паразиты",
            2019,
            "https://ucare.timepad.ru/91198481-1d6f-4a5b-865c-22e335da577c/poster_event_2315049.jpg",
            "Семья бедняков обманом получает работу в доме богачей. Южнокорейская драмеди, которая взяла четыре «Оскара»"
        ),
        Film(
            "Чрезвычайная ситуация",
            2021,
            "https://pic.rutubelist.ru/video/3d/e1/3de1d55d7e2bdbfcdb358112ea9381a1.jpg",
            "На борту самолета стремительно распространяется смертоносный вирус. Фильм-катастрофа со звездой «Паразитов»"
        ),
        Film(
            "Эскобар",
            2017,
            "https://blog.okko.tv/thumb/1320x0/filters:quality(75):no_upscale()/imgs/2023/06/21/00/5951554/23011432eddb35e6494ff486975e132ff0ed5d64.jpeg",
            "Наркобарон глазами влюбленной женщины. Хавьер Бардем и Пенелопа Крус в байопике по книге Вирхинии Вальехо"
        ),
        Film(
            "Дитя робота",
            2019,
            "https://i.ytimg.com/vi/YLhtfshm8fU/maxresdefault.jpg",
            "Можно ли доверять машине, даже если она твоя мама? Неглупый сай-фай триллер на тему ИИ и выживания человечества"
        ),
        Film(
            "Груз 200",
            2007,
            "https://i.ytimg.com/vi/RNdIeryfvNw/maxresdefault.jpg",
            "Милиционер расследует исчезновение дочери секретаря райкома. Самый беспощадный фильм Алексея Балабанова"
        ),
        Film(
            "Золото",
            2016,
            "https://b1.filmpro.ru/c/435823.jpg",
            "Делец и геолог отчаянно ищут золото в джунглях Индонезии. Реальная история финансовой аферы с Мэттью МакКонахи"
        )
    ).toMutableList()

    override fun getItemCount(): Int {
        return films.size
    }

    inner class FilmViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val filmTitle: TextView = itemView.findViewById(R.id.film_title)
        val yearTitle: TextView = itemView.findViewById(R.id.year_title)
        val filmImage: ImageView = itemView.findViewById(R.id.film_image)
    }

    open fun getFilms() = films

}