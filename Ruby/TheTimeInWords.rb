hours = 0
minutes = 0
ARGF.each_with_index do |line, index|
    if index == 0
        hours = line.to_i
    elsif index == 1
        minutes = line.to_i
    else 
        false
    end
end


def the_time_in_words(hours, minutes)
    if hours > 12 or minutes > 60
        false
    end

    final_string = ""

    if minutes == 0
        final_string = convert_number_to_word( hours ) + " o' clock"
    elsif ( minutes / 30 ) < 1
        final_string += "past "

        if minutes == 1
            final_string = "one minute "    
        elsif ( minutes % 15 ) == 0
            final_string = "quarter " + final_string
        else
            final_string = convert_number_to_word( minutes ) + " minutes " + final_string
        end

        final_string += convert_number_to_word( hours )
    else
        final_string += "to "

        if minutes == 59
            final_string = "one minute "            
        elsif ( minutes % 15 ) == 0
            final_string = "quarter " + final_string
        else
            final_string = convert_number_to_word( 60 - minutes ) + " minutes " + final_string
        end

        final_string += convert_number_to_word( hours + 1 )
    end 

    final_string
end

def convert_number_to_word(n)
    words_hash = {0=>"zero",1=>"one",2=>"two",3=>"three",4=>"four",5=>"five",6=>"six",7=>"seven",8=>"eight",9=>"nine",10=>"ten",11=>"eleven",12=>"twelve",13=>"thirteen",14=>"fourteen",15=>"fifteen",16=>"sixteen",17=>"seventeen", 18=>"eighteen",19=>"nineteen", 20=>"twenty",30=>"thirty",40=>"forty",50=>"fifty",60=>"sixty",70=>"seventy",80=>"eighty",90=>"ninety"}
    
    if ( n - 19 ) <= 0
        words_hash[n]
    else 
        words_hash[(n/10).floor] + words.hash[(n%10)]
    end
end 

STDOUT.write the_time_in_words hours, minutes
