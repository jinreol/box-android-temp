package com.example.daggerhilt_retrofit_coroutine.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.daggerhilt_retrofit_coroutine.models.Employee
import com.example.daggerhilt_retrofit_coroutine.databinding.EmployeeItemBinding

class EmployeeAdapter: RecyclerView.Adapter<EmployeeAdapter.EmployeeViewHolder>() {
    inner class EmployeeViewHolder(private val binding: EmployeeItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Employee) {
            binding.tvName.text = "${item.employee_name}"
            binding.tvSalary.text = "Salary: Re.${item.employee_salary}"
            binding.tvAge.text = "Age: ${item.employee_age}"
        }
    }

    private val diffCallback = object: DiffUtil.ItemCallback<Employee>() {
        override fun areItemsTheSame(oldItem: Employee, newItem: Employee): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Employee, newItem: Employee): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }
    }

    private val differ = AsyncListDiffer<Employee>(this, diffCallback)

    fun submitList(list: List<Employee>) = differ.submitList(list)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeViewHolder {
        val binding: EmployeeItemBinding = EmployeeItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return EmployeeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: EmployeeViewHolder, position: Int) {
        val item = differ.currentList[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }
}