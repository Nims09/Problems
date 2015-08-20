count_missing = 0
count_full = []

array_missing = 0
array_full = []

hash_missing = Hash.new
missing_values = Array.new

ARGF.each_with_index do |line, index|
    if index == 0
        count_missing = line.to_i
    elsif index == 1
        array_missing = line.split(" ")
    elsif index == 2
        count_full = line.to_i
    elsif index == 3
        array_full = line.split(" ")        
    else 
        false
    end
end

array_missing.each do |current|
	if hash_missing.has_key? current
		hash_missing[current] = hash_missing[current] + 1
	else
		hash_missing[current] = 1
	end
end

array_full.each do |current|
	if ( hash_missing.has_key? current && hash_missing[current] == 0 ) || ( !hash_missing.has_key? current )
		missing_values.push current
	else
		hash_missing[current] = hash_missing[current] - 1
	end
end

STDOUT.write missing_values.join(" ")
